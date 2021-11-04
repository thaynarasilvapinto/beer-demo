package com.example.demo.architectural_test.core.usecase;

import com.example.demo.architectural_test.config.PackageEnum;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.GeneralCodingRules;

@AnalyzeClasses(packages = "com.example.demo")
public class UseCaseTest {

    @ArchIgnore
    @ArchTest
    static ArchRule no_classes_should_use_field_injection =
            GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    static ArchRule class_adapter_must_be_package_adapter =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("UseCase")
                    .should()
                    .resideInAnyPackage(PackageEnum.USE_CASE.getDescription());

    @ArchTest
    static ArchRule class_adapter_must_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.USE_CASE.getDescription())
                    .should()
                    .beInterfaces();

    @ArchTest
    static ArchRule class_adapter_must_have_the_name_adapter =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.USE_CASE.getDescription())
                    .should()
                    .haveSimpleNameEndingWith("UseCase");

}
