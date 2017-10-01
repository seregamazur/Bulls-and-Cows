package Interface;


import Logic.GenerateNumb;

class NewGame extends GenerateNumb {
   public void newgame(){
       Reader red = new Reader();
       red.cowcount = 0;
       red.bullcount = 0;
       red.guesses = 0;
    go();
}}
