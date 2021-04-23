#!groovy


def configFile = ''
def buildImage = 'persapiens/firefox-openjdk:68-11u4-alpine'

continuousDelivery(configFile) {
  docker.image(buildImage).inside() {
    sh "/usr/bin/xvfb-run ./gradlew --no-daemon --gradle-user-home ${env.GRADLE_LOCAL_HOME} -Djava.security.auth.login.config=ignoreMe.conf -DwebDriverType=firefox -Dcheck -Dtest.type=all clean build "
  }
}
