package com.example.demo.architectural_test.outbound.database.repository;

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

@AnalyzeClasses(packages = "com.example.demo")
public class RepositoryTest {


    @ArchTest
    static ArchRule class_repository_must_be_package_repository =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Repository")
                    .should()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_REPOSITORY.getDescription());

    @ArchTest
    static ArchRule class_repository_should_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("Repository")
                    .should()
                    .beInterfaces();

    @ArchTest
    static ArchRule class_repository_annotation_with_repository_and_table =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_REPOSITORY.getDescription())
                    .should()
                    .beAnnotatedWith(Repository.class);

    @ArchTest
    static ArchRule class_repository_should_not_be_annotations=
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_REPOSITORY.getDescription())
                    .should()
                    .notBeAnnotatedWith(Service.class)
                    .andShould().
                    notBeAnnotatedWith(Entity.class)
                    .andShould().
                    notBeAnnotatedWith(Controller.class)
                    .andShould().
                    notBeAnnotatedWith(RestController.class)
                    .andShould().
                    notBeAnnotatedWith(RequestMapping.class);


    @ArchTest
    static ArchRule class_repository_must_have_the_name_repository =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.OUTBOUND_DATABASE_REPOSITORY.getDescription())
                    .should()
                    .haveSimpleNameEndingWith("Repository");

}

