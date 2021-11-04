package com.example.demo.architectural_test.outbound.database.entity;

import com.example.demo.architectural_test.config.PackageEnum;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Table;

@AnalyzeClasses(packages = "com.example.demo")
public class EntityTest {

    @ArchTest
    static ArchRule class_entity_must_be_package_entity =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Entity")
                    .should()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ENTITY.getDescription());

    @ArchTest
    static ArchRule class_entity_should_not_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Entity")
                    .should()
                    .notBeInterfaces();

    @ArchTest
    static ArchRule class_entity_impl_annotation_with_entity_and_table =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ENTITY.getDescription())
                    .should()
                    .beAnnotatedWith(Entity.class)
                    .andShould()
                    .beAnnotatedWith(Table.class);

    @ArchTest
    static ArchRule class_entity_should_not_be_annotations=
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ENTITY.getDescription())
                    .should()
                    .notBeAnnotatedWith(Service.class)
                    .andShould().
                    notBeAnnotatedWith(Repository.class)
                    .andShould().
                    notBeAnnotatedWith(Controller.class)
                    .andShould().
                    notBeAnnotatedWith(RestController.class)
                    .andShould().
                    notBeAnnotatedWith(RequestMapping.class);


    @ArchTest
    static ArchRule class_entity_must_have_the_name_entity_impl =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_ENTITY.getDescription())
                    .should()
                    .haveSimpleNameEndingWith("Entity");
}
