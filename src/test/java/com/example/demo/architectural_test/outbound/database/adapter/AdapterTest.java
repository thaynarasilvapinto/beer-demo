package com.example.demo.architectural_test.outbound.database.adapter;

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
public class AdapterTest {

    @ArchTest
    static ArchRule class_use_case_impl_must_be_package_use_case_impl =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Adapter")
                    .should()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ADAPTER.getDescription());

    @ArchTest
    static ArchRule class_use_case_impl_should_not_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Adapter")
                    .should()
                    .notBeInterfaces();

    @ArchTest
    static ArchRule class_use_case_impl_annotation_with_service =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ADAPTER.getDescription())
                    .should()
                    .beAnnotatedWith(Component.class);

    @ArchTest
    static ArchRule class_use_case_impl_should_not_be_annotation_with_different_service =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ADAPTER.getDescription())
                    .should()
                    .notBeAnnotatedWith(Service.class)
                    .andShould().
                    notBeAnnotatedWith(Entity.class)
                    .andShould().
                    notBeAnnotatedWith(Repository.class)
                    .andShould().
                    notBeAnnotatedWith(Controller.class)
                    .andShould().
                    notBeAnnotatedWith(RestController.class)
                    .andShould().
                    notBeAnnotatedWith(RequestMapping.class);

    @ArchTest
    static ArchRule class_use_case_should_not_be_interface =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ADAPTER.getDescription())
                    .should()
                    .dependOnClassesThat().resideInAnyPackage(PackageEnum.PORT_DATABASE.getDescription());

    @ArchTest
    static ArchRule class_use_case_must_have_the_name_use_case_impl =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ADAPTER.getDescription())
                    .should()
                    .haveSimpleNameEndingWith("Adapter");
}
