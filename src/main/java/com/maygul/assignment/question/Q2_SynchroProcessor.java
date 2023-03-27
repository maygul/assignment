package com.maygul.assignment.question;

/**
 * Here, I've removed the Initializer class and moved the processor initialization code to the initializeProcessor()
 * method which is called before starting the Executor thread.
 * Also, I've modified the Executor class to extend Thread and added Processor as Constructor parameter.
 * Then, in the startExecutor() method, I'm creating a new instance of Executor,
 * setting the processor instance using the setProcessor() method, and starting a new thread using this instance
 *
 * This ensures that the processor instance is initialized before the process() method is executed in the Executor thread.
 *
 * @author Maygul
 *
 *
 */
public class Q2_SynchroProcessor {

    private Processor processor;

    public static void main(String[] args) {
        Q2_SynchroProcessor q2SynchroProcessor = new Q2_SynchroProcessor();
        q2SynchroProcessor.initializeProcessor();
        q2SynchroProcessor.startExecutor();
    }

    private void initializeProcessor() {
        processor = new Processor();
        processor.init();
    }

    private void startExecutor() {
        Executor executor = new Executor(processor);
        Thread t2 = new Thread(executor);
        t2.start();
    }

    private static class Executor extends Thread {
        private Processor processor;

        public Executor(Processor processor) {
            this.processor = processor;
        }

        public void run() {
            processor.process();
        }
    }
}

class Processor {
    public void init() {
        // do some initialization
    }

    public void process() {
        // do some processing
    }
}