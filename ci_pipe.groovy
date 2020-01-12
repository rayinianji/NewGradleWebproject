node{
     
    stage('SCM Checkout'){
        git url: 'https://github.com/rayinianji/NewGradleWebproject.git',branch: 'master'
    }
    
    /*stage("Gradle Clean Build"){
      def GradleHome = tool name: 'gradle6', type: 'gradle'
      def gradleCMD = "${GradleHome}/bin/gradle"
      sh "${gradleCMD} clean build"
      
    } */

        stage('Gradle Clean Build With Wrapper'){
        //With out below permision clean build will not work
        sh 'chmod +x gradlew'
        sh './gradlew clean build'
    }
}
    /**
    stage('Gradle Clean Build With Wrapper'){
        //With out below permision clean build will not work
        sh 'chmod +x gradlew'
        sh './gradlew clean build'
    }
    **/
    
    stage('Build Docker Image'){
        sh 'docker build -t anjidockerid/gradle-web-app .'
    }
    
    /*stage('Push Docker Image'){
        withCredentials([string(credentialsId: 'Docker_Hub_Pwd', variable: 'Docker_Hub_Pwd')]) {
          sh "docker login -u dockerhandson -p ${Docker_Hub_Pwd}"
        }
        sh 'docker push dockerhandson/gradle-web-app'
     }
     
      stage('Run Docker Image In Dev Server'){
        
        def dockerRun = ' docker run  -d -p 8080:8080 --name gradle-web-app dockerhandson/gradle-web-app'
         
         sshagent(['DOCKER_SERVER']) {
          sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.20.72 docker stop gradle-web-app || true'
          sh 'ssh  ubuntu@172.31.20.72 docker rm gradle-web-app || true'
          sh 'ssh  ubuntu@172.31.20.72 docker rmi -f  $(docker images -q) || true'
          sh "ssh  ubuntu@172.31.20.72 ${dockerRun}"
       }
       
    }
     
     
}*/
