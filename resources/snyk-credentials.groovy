#!groovy

// imports
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.Domain
import com.cloudbees.plugins.credentials.impl.*
import hudson.util.Secret
import jenkins.model.Jenkins
import io.snyk.jenkins.credentials.DefaultSnykApiToken

Jenkins jenkins = Jenkins.getInstance()

def domain = Domain.global()

def env = System.getenv()

def store = jenkins.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

def snykApi = new DefaultSnykApiToken(
        CredentialsScope.GLOBAL,
        'snyk_token',
        'Snyk Token',
        env['SNYK_API_TOKEN']
)

// add credential to store
store.addCredentials(domain, snykApi)

println "--> creating Snyk API token"

// save to disk
jenkins.save()