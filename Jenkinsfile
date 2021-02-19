//CODE_CHANGE = getGitChanges()

pipeline {
    agent any // any agent... but what is 'agent'?
    environment{
        ENV_VERSION = '5.2.0' // define environment variable 
        SERVER_CREDENTIAL  = credentials('000de9c6-c646-4873-a968-e7598cf5c43f')
    }

    parameters{
        string(name:'WhoAmI', defaultValue:'Freddie', description:'a string name')
        choice(name:'WhoIsMe', choices: ['Freddie', 'Junhao', 'Aaron'], description: 'Why Aaron? Cannot forget him?')
        booleanParam(name:'forget', defaultValue:false, description:'you a loser')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building succeed ... hello from Freddie'
                echo "Build Version: ${ENV_VERSION} (double)"
                echo 'Build Version: ${ENV_VERSION} (single)'
                //echo CODE_CHANGE

                echo params.WhoAmI

                sh 'make' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
            }
        }
        stage('Test') {
            when {
                // run echo 'Testing succeed as well ... nihao from Freddie'
                // only when it is on the master branch
                expression {
                    BRANCH_NAME == 'master' || params.forget == true// || BRANCH_NAME == 'dev'
                }
            }
            steps {
                echo 'Testing succeed as well ... nihao from Freddie'
                sh 'make check || true' 
                junit '**/target/*.xml'
            }
        }
        stage('Deploy') {
            
            when{
                expression{
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }

            steps {

                // 从上到下，按顺序运行
                
                echo 'Deploying done .... say bye to Freddie '
                echo params.WhoIsMe
                sh 'make publish'

                retry(3) { // retry up to 3 times
                    sh './flakey-deploy.sh'
                }

                timeout(time: 3, unit: 'MINUTES') { // must finish in 3 minutes, otherwise will be marked as failed. 
                    sh './health-check.sh'
                }
            }
        }
    }

    post{
        // Conditions:
        //  * always
        //  * success
        //  * failure
        //  * unstable
        //  * changed

        always{
            echo 'always .... from Freddie'
            echo "${SERVER_CREDENTIAL}"

            echo "${JAVA_HOME}"
            echo "${env.JAVA_HOME}"

            //sh "${SERVER_CREDENTIAL}"
        }

        success{
            echo 'succees of Post Action, by Freddie'
        }

        failure{
            // but need to set up smpt server on jenkins first
            mail to: 'junhao.zhang.freddie@gmail.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}