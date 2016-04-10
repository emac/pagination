package cn.emac.demo.pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Emac
 * @since 2016-04-10
 */
@Controller
public class DistrictController {

    @Autowired
    private DistrictRepository districtRepository;

    @RequestMapping("/")
    public String list(Model model, Pageable pageable) {
        Page<District> page =districtRepository.findAll(pageable);
        model.addAttribute("page", new LinkedPage(page, "/"));
        return "index";
    }
}
