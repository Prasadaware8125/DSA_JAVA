import java.util.*;
// Given an array of jobs where every job has a deadline and profit if the job is finished
// before the deadline. It is also given that every job takes a single unit of time, so thej
// minimum possible deadline for any job is 1. Maximize the total profit if only one job can
// be scheduled at a time.

// Eg.
// Job A = 4, 20
// Job B = 1, 10
// Job C = 1, 40
// Job D = 1, 30

// ans = C, A

// Time Complexity = O(nlogn)
// Space Complexity = O(n)
public class Job_Sequencing_Problem {
    // Creating Job object (class) to store job info in the form of Arraylist
    static class Job{
        int deadline;
        int profit;
        int id;

        
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        // {deadline, profit}
        int jobsInfo[][] = {
            {4, 20},
            {1, 10},
            {1, 40},
            {1, 30}
        };

        // Created arraylist of objects of Job(class)
        ArrayList<Job> jobs = new ArrayList<>();


        // Storing Job(object) in arraylist
        for( int i = 0 ; i < jobsInfo.length ; i++ ) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort in descending order of profit
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit );    // descending

        // for ascending Collections.sort(jobs, (obj1,obj2) -> obj1.profit-obj2.profit );

        // Created array list to store sequence of final jobs that can be done for maximum profit
        ArrayList<Integer> seq = new ArrayList<>();

        // Initial time is zero as no job is done
        int time = 0;

        // Iterating jobs (arraylist)
        for( int i = 0 ; i < jobs.size() ; i++ ) {
            // current job(object)
            Job curr = jobs.get(i);
            // If current job's deadline is more than last jobs done then this job can be done
            if( curr.deadline > time ) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs = "+seq.size());
        System.out.print("Jobs : ");
        for( int i = 0 ; i < seq.size() ; i++ ) {
            // converting the sequence(int) to char as A B 
            System.out.print((char)('A'+seq.get(i))+" ");
            // eg seq.get(i) = 2
            // then (char)('A'+2) will be C
        }
    }
}