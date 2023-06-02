package co.grandcircus.taskmanager.dataloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import co.grandcircus.taskmanager.model.Task;
import co.grandcircus.taskmanager.service.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {


    private TaskService taskService;
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    public DataInitializer(TaskService taskService) {

        this.taskService = taskService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        LocalDate today = LocalDate.now();

        taskService.createTask(new Task(
                "Grocery shopping",
                "Going to the supermarket or grocery store to purchase food and other household items.",
                today.minusDays(10),
                true
        ));

        taskService.createTask(new Task(
                "Cooking a meal",
                "Preparing and cooking a meal from scratch, including selecting recipes, chopping ingredients, and following cooking instructions.",
                today.minusDays(20),
                true
        ));

        taskService.createTask(new Task(
                "Doing laundry",
                "Sorting, washing, drying, and folding clothes and other fabric items.",
                today.minusDays(30),
                true
        ));


        taskService.createTask(new Task(
                "Cleaning the house",
                "Performing general cleaning tasks such as vacuuming, mopping floors, dusting surfaces, and tidying up living spaces.",
                today.minusDays(40),
                true
        ));


        taskService.createTask(new Task(
                "Paying bills",
                "Managing and paying monthly bills for utilities, rent/mortgage, internet, phone, and other services.",
                today.minusDays(5),
                false
        ));

        taskService.createTask(new Task(
                "Exercising",
                "Engaging in physical activities such as going for a run, attending a fitness class, or working out at the gym.",
                today.minusDays(2),
                false
        ));

        taskService.createTask(new Task(
                "Commuting to work",
                "Traveling from home to the workplace using public transportation, driving, or cycling.",
                today.minusDays(1),
                false
        ));

        taskService.createTask(new Task(
                "Managing personal finances",
                "Budgeting, tracking expenses, and managing bank accounts, credit cards, and investments.",
                today,
                false
        ));

        taskService.createTask(new Task(
                "Meeting with friends",
                "Planning and organizing social gatherings with friends, including choosing a venue, coordinating schedules, and confirming details.",
                today.plusDays(10),
                false
        ));

        taskService.createTask(new Task(
                "Relaxing and leisure activities",
                "Engaging in hobbies, reading books, watching movies or TV shows, playing games, or simply taking time to relax and unwind.",
                today.plusDays(20),
                false
        ));


        taskService.findAll().stream().map(t -> "saved task: '" + t.getName()
                ).forEach(logger::info);
    }

}
