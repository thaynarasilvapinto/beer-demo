package com.example.demo.architectural_test.core.usecase.impl;

import com.example.demo.architectural_test.config.PackageEnum;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.Set;

@AnalyzeClasses(packages = "com.example.demo")
public class UseCaseImplTest {

    @ArchTest
    static ArchRule class_use_case_impl_must_be_package_use_case_impl =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("UseCaseImpl")
                    .should()
                    .resideInAnyPackage(PackageEnum.USE_CASE_IMPL.getDescription());

    @ArchTest
    static ArchRule class_use_case_impl_should_not_be_a_interface =
            ArchRuleDefinition.classes().that()
                    .haveSimpleNameEndingWith("UseCaseImpl")
                    .should()
                    .notBeInterfaces();

    @ArchTest
    static ArchRule class_use_case_impl_annotation_with_service =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.USE_CASE_IMPL.getDescription())
                    .should()
                    .beAnnotatedWith(Service.class);

    @ArchTest
    static ArchRule class_use_case_impl_should_not_be_annotation_with_different_service =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.USE_CASE_IMPL.getDescription())
                    .should()
                    .notBeAnnotatedWith(Component.class)
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
                    .resideInAnyPackage(PackageEnum.USE_CASE_IMPL.getDescription())
                    .should()
                    .dependOnClassesThat().resideInAnyPackage(PackageEnum.USE_CASE.getDescription());

    @ArchTest
    static ArchRule class_use_case_must_have_the_name_use_case_impl =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.USE_CASE_IMPL.getDescription())
                    .should()
                    .haveSimpleNameEndingWith("UseCaseImpl");

    @ArchTest
    static ArchRule custom_role =
            ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PackageEnum.USE_CASE_IMPL.getDescription())
                    .should(containsSpecificMethod("execute"));

    private static ArchCondition<JavaClass> containsSpecificMethod(String methodName){
        return new ArchCondition<JavaClass>("Must contain a specific method") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
                final String name = javaClass.getName();
                final Set<JavaMethod> methods = javaClass.getMethods();
                boolean hasMethod = false;

                for (JavaMethod method: methods) {
                    if(method.getName().equals(methodName)){
                        hasMethod = true;
                    }
                }

                if(!hasMethod){
                    throw new AssertionError(String.format("Class %s does not have the %s method", name, methodName));
                }
            }
        };
    }

}
