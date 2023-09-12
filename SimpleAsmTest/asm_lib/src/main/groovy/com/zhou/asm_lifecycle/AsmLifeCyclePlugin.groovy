package com.zhou.asm_lifecycle

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

public class AsmLifeCyclePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "==== GOTO    MY GRADLE PLUGIN 222222========"

        def android = project.extensions.getByType(AppExtension)
        println "---------- READY TO REGISTER LifeCycleTransform----------"
        LifeCycleTransform transform = new LifeCycleTransform()
        android.registerTransform(transform)

    }
}