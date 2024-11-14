load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# ------------------------------------------------------------------------------------
# manual junit setup, could also use the maven_install rule below
http_archive(
    name = "junit4",
    url = "https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar",
)

# ------------------------------------------------------------------------------------
# kotlin setup, from: https://github.com/bazelbuild/rules_kotlin?tab=readme-ov-file#workspace
# ------------------------------------------------------------------------------------
rules_kotlin_version = "1.9.0"
rules_kotlin_sha = "5766f1e599acf551aa56f49dab9ab9108269b03c557496c54acaf41f98e2b8d6"
http_archive(
    name = "rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v%s/rules_kotlin-v%s.tar.gz" % (rules_kotlin_version, rules_kotlin_version)],
    sha256 = rules_kotlin_sha,
)

load("@rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below

load("@rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
kt_register_toolchains() # to use the default toolchain, otherwise see toolchains below


# ------------------------------------------------------------------------------------
# maven trick in the workspace, adapted from 
# https://github.com/bazel-contrib/rules_jvm_external?tab=readme-ov-file#with-workspace-file-legacy
# ------------------------------------------------------------------------------------
RULES_JVM_EXTERNAL_TAG = "4.5"
RULES_JVM_EXTERNAL_SHA = "b17d7388feb9bfa7f2fa09031b32707df529f26c91ab9e5d909eb1676badd9a6"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        # "junit:junit:4.12",
        "commons-cli:commons-cli:1.9.0"
    ],
    repositories = [
        # Private repositories are supported through HTTP Basic auth
        "http://username:password@localhost:8081/artifactory/my-repository",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)