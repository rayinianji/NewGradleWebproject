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
    jobFilters {
        status {
            status(Status.UNSTABLE)
        }
    }
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