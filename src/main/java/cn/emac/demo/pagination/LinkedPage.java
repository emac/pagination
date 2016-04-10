package cn.emac.demo.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emac
 * @since 2016-04-10
 */
public class LinkedPage<T> {

    public static final int MAX_PAGE_ITEM_DISPLAY = 5;

    private Page<T> page;
    @Getter
    private List<PageItem> items;
    @Getter
    private int number;
    @Getter
    @Setter
    private String url;

    /**
     * @param page
     * @param url
     */
    public LinkedPage(Page<T> page, String url) {
        this.page = page;
        this.url = url;
        items = new ArrayList<>();
        number = page.getNumber();

        int start, size;
        if (page.getTotalPages() <= MAX_PAGE_ITEM_DISPLAY) {
            start = 1;
            size = page.getTotalPages();
        } else {
            int half = MAX_PAGE_ITEM_DISPLAY / 2;
            if (number + half <= MAX_PAGE_ITEM_DISPLAY) {
                // 2/6 -> 1,2,3,4,5
                start = 1;
            } else if (number + half >= page.getTotalPages()) {
                // 5/6 -> 2,3,4,5,6
                start = page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY + 1;
            } else {
                // 4/6 -> 2,3,4,5,6
                start = number - half + 1;
            }
            size = MAX_PAGE_ITEM_DISPLAY;
        }

        for (int i = 0; i < size; i++) {
            items.add(new PageItem(start + i, (start + i) == (number + 1)));
        }
    }

    public List<T> getContent() {
        return page.getContent();
    }

    public int getSize() {
        return page.getSize();
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public boolean isFirst() {
        return page.isFirst();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean isHasPrevious() {
        return page.hasPrevious();
    }

    public boolean isHasNext() {
        return page.hasNext();
    }

    @AllArgsConstructor
    @Getter
    public static class PageItem {

        private int number;
        private boolean current;
    }
}