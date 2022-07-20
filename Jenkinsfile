pipeline {
   agent any

    parameters {        
        file(description: 'Input File')
    }

   stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/cloudrural/java-project.git']]])
                sh "ls -lart ./*"
            }
        }
        stage('Compile') {
            steps {
               sh "javac -d bins/Automation src/Automation/*.java"
            }
        }
        stage('Execute Script') {
            steps {
                fileParam('file.txt') {
                  sh 'java -classpath bins/Automation/ Main'
                }
            }
        }
    }
}
