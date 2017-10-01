package Interface;


import Logic.GenerateNumb;

class NewGame extends Reader {
    GenerateNumb gen = new GenerateNumb();
   public void newgame(){
       cowcount = 0;
       bullcount = 0;
       guesses = 0;
    gen.go();
}}
