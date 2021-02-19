//CODE_CHANGE = getGitChanges()

pipeline {
    agent any // any agent... but what is 'agent'?
    environment{
        ENV_VERSION = '5.2.0' // define environment variable 
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building succeed ... hello from Freddie'
                echo "Build Version: ${ENV_VERSION} (double)"
                echo 'Build Version: ${ENV_VERSION} (single)'
                //echo CODE_CHANGE
            }
        }
        stage('Test') {
            when {
                // run echo 'Testing succeed as well ... nihao from Freddie'
                // only when it is on the master branch
                expression {
                    BRANCH_NAME == 'master' // || BRANCH_NAME == 'dev'
                }
            }
            steps {
                echo 'Testing succeed as well ... nihao from Freddie'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying done .... say bye to Freddie '
            }
        }
    }

    post{
        // Conditions:
        //  * always
        //  * success
        //  * failure
        always{
            echo 'always .... from Freddie'
        }

        success{
            echo 'succees of Post Action, by Freddie'
        }
    }
}