pipeline {
    agent any
    
    tools { 
        maven 'maven_3.8.2' 
        jdk 'jdk11' 
    }
    
    stages {
        stage('Compile') {
            steps {
                sh "mvn clean install"
            }
        }
    }
}
