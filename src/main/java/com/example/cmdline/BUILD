load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "runner",
    srcs = ["Runner.java"],
    main_class = "com.example.cmdline.Runner",
    deps = ["//:greeter", "@maven//:commons_cli_commons_cli"],
)
