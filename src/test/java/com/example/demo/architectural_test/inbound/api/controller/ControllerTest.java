package com.example.demo.architectural_test.inbound.api.controller;

import com.example.demo.architectural_test.config.PackageEnum;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@AnalyzeClasses(packages = "com.example.demo")
public class ControllerTest {

    @ArchTest
    static ArchRule class_controller_must_be_package_controller =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Controller")
                    .should()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_CONTROLLER.getDescription());

    @ArchTest
    static ArchRule class_controller_should_not_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_CONTROLLER.getDescription())
                    .should()
                    .notBeInterfaces();

    @ArchTest
    static ArchRule class_controller_annotation_with_controller =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_CONTROLLER.getDescription())
                    .should()
                    .beAnnotatedWith(RestController.class)
                    .andShould()
                    .beAnnotatedWith(RequestMapping.class);

    @ArchTest
    static ArchRule class_use_case_impl_should_not_be_annotations =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_CONTROLLER.getDescription())
                    .should()
                    .notBeAnnotatedWith(Component.class)
                    .andShould().
                    notBeAnnotatedWith(Entity.class)
                    .andShould().
                    notBeAnnotatedWith(Repository.class)
                    .andShould().
                    notBeAnnotatedWith(Service.class)
                    .andShould().
                    notBeAnnotatedWith(Controller.class);

}
