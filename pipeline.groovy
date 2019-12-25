folder ('project-a')
{}
pipelineJob('project-a/firstpiprline') {
    
    definition {
        cps {
            script(readFileFromWorkspace('ci_pipe.groovy'))
            sandbox()
        }
    }
}
