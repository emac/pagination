#!groovy

stage 'package'
node {
    checkout scm
    mvn 'clean package'
}

stage 'test'
node {
    deploy('test')
    testAlive('')
}

input '发布到生产环境？'
    
stage 'production'
node {
    deploy('prod')
    testAlive('')
}

def mvn(args) {
    sh "${tool 'Maven 3.x'}/bin/mvn ${args}"
}

def deploy(env) {
	dir('target') {
		sh "mkdir -p envs/$env"
		sh "cp pagination.jar envs/$env"
	}
}

def testAlive(url) {
	sleep 3
}