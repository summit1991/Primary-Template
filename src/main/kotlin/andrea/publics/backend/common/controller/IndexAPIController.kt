package andrea.publics.backend.common.controller

import andrea.publics.backend.constants.API_PATH_PREFIX_V1
import andrea.publics.backend.domain.menu.dto.MenuGroupDTO
import mu.KotlinLogging
import org.springframework.boot.task.TaskSchedulerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.util.DigestUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.WebApplicationContext
import java.util.concurrent.ThreadPoolExecutor


@RequestMapping(API_PATH_PREFIX_V1)
@RestController
class IndexAPIController constructor(
    private val resourceLoader: ResourceLoader
) {
    @GetMapping("/index")
    fun index(): Any {
        Thread.sleep(10000)
        return "인덱스 데이터"
    }

    @GetMapping("/menus")
    fun menus(): Any {
        return MenuGroupDTO.dummyMenu
    }

//    @Async
//    @Scheduled(fixedDelay = 1000)
//    fun 해당_스케줄의_태스크가_끝나고_1초_이후에_다시_퍼블라이즈드() {
//        println("${Thread.currentThread().name} delay started");
//        Thread.sleep(((Math.random() * (1500 - 100)) + 100).toLong())
//        println("${Thread.currentThread().name} delay is finished.");
//    }
//
//
     @Async("specifiedTaskExecutor")
    @Scheduled(initialDelay = 1000, fixedRate = 100)
    fun 해당_스케줄은_최초에_1초_뻐기고_1초_간격으로_퍼블라이즈드() {
        println("${Thread.currentThread().name} fixedRateJob started")
        Thread.sleep(((Math.random() * (1500 - 100)) + 100).toLong())
        println("${Thread.currentThread().name} fixedRateJob is finished.")
    }

    private val log = KotlinLogging.logger { }

//
//    @Async("specifiedTaskExecutor")
//    @Scheduled(fixedRate = 500)
//    fun 굿잡() {
//        println("${Thread.currentThread().name} 시작")
//
//        Thread.sleep(((Math.random() * (1500 - 100)) + 100).toLong())
////        var i = 0
////        while (i < 500000) {
////            resourceLoader.getResource("classpath:good").file.writeText("asdf")
////            i++
////        }
//
//        println("${Thread.currentThread().name} 종료")
//    }

//    @Scheduled(initialDelay = 1000, fixedDelay = 1000)
//    fun 마구발싸() {
//        println("우효")
//    }
}



//@Configuration
//class ScheduleConfig : SchedulingConfigurer {
//    override fun configureTasks(
//        taskRegistrar: ScheduledTaskRegistrar
//    ) {
//        val threadPoolTaskScheduler = ThreadPoolTaskScheduler()
//        threadPoolTaskScheduler.poolSize = 3
//        threadPoolTaskScheduler.setThreadNamePrefix("Driven BY SC")
//        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true)
//        threadPoolTaskScheduler.set
//        threadPoolTaskScheduler.initialize()
//
//        taskRegistrar.setTaskScheduler(threadPoolTaskScheduler)
//    }
//}

//@Configuration
//class AsyncConfig : TaskExecutorCustomizer {
//    override fun customize(taskExecutor: ThreadPoolTaskExecutor) {
//        taskExecutor.corePoolSize = 10
//        taskExecutor.maxPoolSize = 10
//        taskExecutor.queueCapacity = 0
//        taskExecutor.setThreadNamePrefix("Driven BY TE")
//        taskExecutor.setRejectedExecutionHandler(ThreadPoolExecutor.DiscardPolicy())
//        taskExecutor.initialize()
//    }
//}

@Configuration
class TaskExecutorCustomizationConfig {
    @Bean
    fun taskSchedulerCustomizer(): TaskSchedulerCustomizer? {
        return TaskSchedulerCustomizer { taskScheduler: ThreadPoolTaskScheduler ->
            taskScheduler.setAwaitTerminationSeconds(60)
            taskScheduler.setWaitForTasksToCompleteOnShutdown(true)
            taskScheduler.poolSize = 3
        }
    }

    @Bean
    fun taskExecutor(): TaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 3
        executor.setThreadNamePrefix("Default_TE")

        return executor
    }

    @Bean
    fun specifiedTaskExecutor(): TaskExecutor {
        val executor = ThreadPoolTaskExecutor()
        executor.setThreadNamePrefix("Specified_TE")
        executor.maxPoolSize = 3
        executor.corePoolSize = 1
        executor.queueCapacity = 0
        executor.setAwaitTerminationSeconds(30)
        executor.setWaitForTasksToCompleteOnShutdown(true)
        executor.setRejectedExecutionHandler(ThreadPoolExecutor.DiscardPolicy())
        return executor
    }
}

