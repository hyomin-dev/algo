class Solution {
    public int solution(int hp) {
        int generalAnt = 5;
        int soldierAnt = 3;
        int workerAnt = 1;

        int total = 0;

        if(hp>=generalAnt){
            int num = hp/generalAnt;
            hp -=num*generalAnt;
            total+=num;
        }

        if(hp>=soldierAnt){
            int num = hp/soldierAnt;
            hp-=num*soldierAnt;
            total+=num;
        }

        if(hp>=workerAnt){
            int num = hp/workerAnt;
            hp-=num*workerAnt;
            total+=num;
        }

        return total;
    }
}