package com.supsp.shop.model;

import com.supsp.springboot.core.generator.GeneratorUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Generator {

    public static void main(String[] args) throws Exception  {
        // /opt/devs/projects/sup/project/supsp-shop/src/main/java/com/supsp/shop
        System.setProperty("project", "supsp-shop");
        System.setProperty("userDir", System.getProperty("user.dir"));
        System.setProperty("javaDir", "/java/com/supsp/shop");

        System.setProperty("pkgParent", "com.supsp");
        System.setProperty("parentModule", "springboot");

        // com.supsp.springboot.core.model.
        System.setProperty("projectPkgParent", "com.supsp");
        System.setProperty("projectParentModule", "shop");

        //
        System.setProperty("dbHost", "127.0.0.1");
        System.setProperty("dbPort", "3306");
        System.setProperty("dbUser", "xbzx");
        System.setProperty("dbPwd", "Root123!!##");
        System.setProperty("dbName", "sup_shop");


        GeneratorUtil.doGenerator();
    }
}
