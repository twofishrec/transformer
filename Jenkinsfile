pipeline {
  agent any
  stages {
    stage('Pull') {
      steps {
        git(url: 'https://github.com/twofishrec/transformer.git', branch: 'blue-ocean')
      }
    }
    stage('') {
      steps {
        sh 'mvn clean compile'
      }
    }
  }
}
