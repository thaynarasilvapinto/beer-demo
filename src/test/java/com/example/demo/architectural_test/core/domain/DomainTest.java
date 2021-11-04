package com.example.demo.architectural_test.core.domain;

import com.example.demo.architectural_test.config.PackageEnum;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@AnalyzeClasses(packages = "com.example.demo")
public class DomainTest {

    @ArchTest
    static ArchRule class_port_must_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.DOMAIN.getDescription())
                    .should()
                    .notBeInterfaces();

    @ArchTest
    static ArchRule class_port_should_not_be_annotations =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.DOMAIN.getDescription())
                    .should()
                    .notBeAnnotatedWith(Component.class)
                    .andShould()
                    .notBeAnnotatedWith(Service.class)
                    .andShould().
                    notBeAnnotatedWith(Entity.class)
                    .andShould().
                    notBeAnnotatedWith(Repository.class)
                    .andShould().
                    notBeAnnotatedWith(Autowired.class)
                    .andShould().
                    notBeAnnotatedWith(Controller.class);

}
