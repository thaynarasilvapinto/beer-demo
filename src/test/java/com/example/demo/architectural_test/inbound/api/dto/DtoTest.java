package com.example.demo.architectural_test.inbound.api.dto;

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
import java.io.Serializable;

@AnalyzeClasses(packages = "com.example.demo")
public class DtoTest {

    @ArchTest
    static ArchRule class_dto_must_be_package_dto =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Dto")
                    .should()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_DTO.getDescription());

    @ArchTest
    static ArchRule class_dto_must_have_the_name_dto =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_DTO.getDescription())
                    .should()
                    .haveSimpleNameEndingWith("Dto");

    @ArchTest
    static ArchRule class_dto_should_not_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_DTO.getDescription())
                    .should()
                    .notBeInterfaces();

    @ArchTest
    static ArchRule class_dto_should_be_implement_serializable =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_DTO.getDescription())
                    .should()
                    .implement(Serializable.class);


    @ArchTest
    static ArchRule class_use_case_impl_should_not_be_annotations =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.INBOUND_API_DTO.getDescription())
                    .should()
                    .notBeAnnotatedWith(Component.class)
                    .andShould().
                    notBeAnnotatedWith(Entity.class)
                    .andShould().
                    notBeAnnotatedWith(Repository.class)
                    .andShould().
                    notBeAnnotatedWith(Service.class)
                    .andShould().
                    notBeAnnotatedWith(RestController.class)
                    .andShould().
                    notBeAnnotatedWith(RequestMapping.class)
                    .andShould().
                    notBeAnnotatedWith(Controller.class);
}
