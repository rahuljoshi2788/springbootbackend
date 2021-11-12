pipeline { // root 
    agent any                         // agent is any so jenkins will execute this task on any agent/node & this is for declarative pipline

    stages {                            // This section allows to generate different stages on your pipeline that will be visualized as different segments when the job is run.

        stage('deploy') {           //At least one “stage” section must be defined on the “stages” section. It will contain the work that the pipeline will execute.
            steps {
                sh ""mvn package""  // for build the jar
            }
        }

        stage('Build Docker image'){// Build the docker image 
            steps {

                sh 'docker build -t  rahuljoshi2788/docker-jenkins-aws:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login'){ // Docker hub login

            steps {
                 withCredentials([string(credentialsId: 'rahuljoshi2788', variable: 'June@1234')]) {
                    sh ""docker login -u rahuljoshi2788 -p ${June@1234}""
                }
            }
        }

        stage('Docker Push'){    // push the image to docker hub
             steps {
                sh 'docker push rahuljoshi2788/docker-jenkins-aws:${BUILD_NUMBER}'
            }
        }

        stage('deploy on production'){   // if branch is production then run the docker image on 8082
              when{
                    expression{ env.GIT_BRANCH =='origin/production'}
                  }

            steps {

                     sh 'docker stop $(docker ps --filter publish=8082/tcp -q)'
                     sh 'docker run -itd -p  8082:8082 rahuljoshi2788/docker-jenkins-aws:${BUILD_NUMBER}'
            }
        }

        stage('deploy on master'){  // if branch is master then run the docker image on 8081

         when{
                expression{ env.GIT_BRANCH =='origin/master'}
              }
                    steps {
                            echo 'pulling ..'+ env.GIT_BRANCH

                            sh 'docker stop $(docker ps --filter publish=8081/tcp -q)'
                            sh 'docker run -itd -p  8081:8081 rahuljoshi2788/docker-jenkins-aws:${BUILD_NUMBER}'
                          }

        }

        stage('Archiving') { //result of build process
            steps {
                 archiveArtifacts '**/target/*.jar'
            }

        }
    }
}