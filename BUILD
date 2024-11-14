load("@rules_java//java:defs.bzl", "java_binary")
load("@rules_java//java:defs.bzl", "java_test")
load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])


java_binary(
    name = "ProjectRunner",
    srcs = ["src/main/java/com/example/ProjectRunner.java"],
    main_class = "com.example.ProjectRunner",
    deps = [":greeter"],
)

kt_jvm_library(
    name = "greeter",
    srcs = ["src/main/java/com/example/Greeting.kt"],
    visibility = ["//src/main/java/com/example/cmdline:__pkg__"],
)

java_library(
    name = "greeter_java",
    srcs = ["src/main/java/com/example/Greeting.java"],
    visibility = ["//src/main/java/com/example/cmdline:__pkg__"],
)

java_test(
    name = "GreeterTest",
    deps = ["//:greeter"],
    srcs = ["src/test/java/com/example/GreetingTest.java"],
    test_class = "test.java.com.example.GreetingTest"
)
