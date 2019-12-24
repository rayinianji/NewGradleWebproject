listView('GERFTEST') {
    description('gerf jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        name('GERF-DEV')
        name('GERF-QA')
        name('GERF-TEST')
        name('GERF-PROD')
                
    }
    /*jobFilters {
        status {
            status(Status.UNSTABLE)
        }
    }*/
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}
folder('project-a') {
    displayName('Project A')
    description('Folder for project A')
}
folder('project-B') {
    displayName('Project B')
    description('Folder for project B')
}
