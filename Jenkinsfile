pipeline {
   agent any

   stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/cloudrural/java-project.git']]])
                sh "ls -lart ./*"
            }
        }
        stage('Compile') {
               sh "javac -d bins/Automation src/Automation/*.java"
        }
        stage('Execute Script') {
                withFileParameter('/src/Automation/input.txt') {
                writeFile file: 'input.yaml', file: params.INPUT
                  sh 'java -classpath bins/Automation/ Main'
                }
        }
    }
}



properties([parameters([file(description: 'inout file', name: '$workspace/input.txt'), string(defaultValue: 'sPath', name: 'sPath'), string(defaultValue: 'sPath1', name: 'sPath1')])])

node {

        stage('Checkout') {
                git url: 'https://github.com/cloudrural/java-project.git', branch: 'master'
                sh "ls -lart ./*"
        }
        stage('Compile') {
               sh "javac -d bins/Automation src/Automation/*.java"
        }
        stage('Execute Script') {
            def inputFile = input message: 'Upload file', parameters: [file(name: "$workspace/input.txt")]
            sh 'java -classpath bins/Automation/ Main'
        }
}

properties([parameters([file(description: 'inout file', name: 'input.txt'), string(defaultValue: 'sPath', name: 'sPath'), string(defaultValue: 'sPath1', name: 'sPath1')])])

def fileBase64 = input message: 'Please provide a file', parameters: [base64File('input.txt')]

pipeline {
   agent any
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
                steps{
                    withEnv(["fileBase64=$fileBase64"]) {
                        sh 'echo $fileBase64 | base64 -d > src/input.txt'
                        // powershell '[IO.File]::WriteAllBytes("myFile.txt", [Convert]::FromBase64String($env:fileBase64))'
                    }
                    
                    sh 'java -classpath bins/Automation/ Main'
                }
        }
    }
}

