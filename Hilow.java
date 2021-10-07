import org.w3c.dom.ls.LSOutput;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
deck card[] = new deck[52]; //Deck of 52 cards
for (int i = 0; i<=51; i++)
{
card[i] = new deck(); // Initialize each card in the deck
}
game_play value=new game_play(); //Start game
value.load(card); //Load the cards
value.shuffle(card); //Shuffle the deck
String playerGuess; //String to hold H/L
deck dealerCard; //Holder for the dealer card
deck playerCard; //Holder for player card
int bet; //player bet
value.setBank(); // Set initial bank to 0
while(value.playGame){ //playGame boolean dictates whether to keep playing
Scanner scanner = new Scanner(System.in); //Read in values
System.out.println("How much would you like to bet? ");
bet = Integer.parseInt(scanner.next()); //Get bet
playerCard = value.dealCard(card); //Deal card
if(playerCard.dealt=true){
playerCard = value.dealCard(card);//if its been dealt already deal another
}else{
playerCard.dealt=true;
};
System.out.println("Your card is "+playerCard.card_name+" "+
playerCard.card_type+" "+playerCard.card_value); //Show player card
System.out.println("Will the dealer card be higher or lower? (H/L): ");
playerGuess = scanner.next(); //Get higher or lower
dealerCard = value.dealCard(card); //Deal dealer card
if(dealerCard.dealt=true){ //if dealer card has been dealt deal another
dealerCard = value.dealCard(card);
}else{
dealerCard.dealt=true;
};
System.out.println("The dealer card is "+dealerCard.card_name+" "+ //Show dealer card after guess
dealerCard.card_type+" "+dealerCard.card_value);
dealerCard.dealt = true;
if(dealerCard.card_value == playerCard.card_value){ //If tie do nothing and check play again
System.out.println("Tie");
value.playGame=value.playAgain();
}
else if (dealerCard.card_value > playerCard.card_value){
if(playerGuess.equals("H")){ //if correct double bet to bank and go through again
System.out.println("You are correct");
value.addBank(bet*2);
}else{
System.out.println("You are incorrect"); //if incorrect subtract double bet from bank and check
value.deductBank(bet*2);
value.playGame=value.playAgain();
}
}
else {
if(playerGuess.equals("L")){
System.out.println("You are correct");
value.addBank(bet*2);
}else{
System.out.println("You are incorrect");
value.deductBank(bet*2);
value.playGame=value.playAgain();
}
}
playerCard = dealerCard;//Progress through / increment to next iteration
}
System.out.println("Game over");
if(value.timesPlayed==10){
System.out.println("Sorry you cannot play more than 10 times");
}
if(value.playerBank>=0){
System.out.println("Congrats you have won $"+value.playerBank+" and you played
"+value.timesPlayed);
}
else{
System.out.println("Sorry you have lost $"+value.playerBank+" and you played
"+value.timesPlayed);
}
//value.printdeck(card);
System.exit(0);
}
}
class game_play
{
int i;
int cardUsed; //Holds cards used
int playerBank =0; //Initial bank
int timesPlayed = 1; //Will play atleast one time
boolean playGame= true; //Keep play game true unless player wants to change to exit
void load(deck card[]) //Card values
{
card[0].card_name="TWO";
card[0].card_type="heart";
card[0].card_value=2;
card[0].dealt=false;
card[1].card_name="THREE";
card[1].card_type="heart";
card[1].card_value=3;
card[1].dealt=false;
card[2].card_name="FOUR";
card[2].card_type="heart";
card[2].card_value=4;
card[2].dealt=false;
card[3].card_name="FIVE";
card[3].card_type="heart";
card[3].card_value=5;
card[3].dealt=false;
card[4].card_name="SIX";
card[4].card_type="heart";
card[4].card_value=6;
card[4].dealt=false;
card[5].card_name="SEVEN";
card[5].card_type="heart";
card[5].card_value=7;
card[5].dealt=false;
card[6].card_name="EIGHT";
card[6].card_type="heart";
card[6].card_value=8;
card[6].dealt=false;
card[7].card_name="NINE";
card[7].card_type="heart";
card[7].card_value=9;
card[7].dealt=false;
card[8].card_name="TEN";
card[8].card_type="heart";
card[8].card_value=10;
card[8].dealt=false;
card[9].card_name="ACE";
card[9].card_type="heart";
card[9].card_value=1;
card[9].dealt=false;
card[10].card_name="JACK";
card[10].card_type="heart";
card[10].card_value=10;
card[10].dealt=false;
card[11].card_name="QUEEN";
card[11].card_type="heart";
card[11].card_value=10;
card[11].dealt=false;
card[12].card_name="KING";
card[12].card_type="heart";
card[12].card_value=10;
card[12].dealt=false;
card[13].card_name="TWO";
card[13].card_type="diamond";
card[13].card_value=2;
card[13].dealt=false;
card[14].card_name="THREE";
card[14].card_type="diamond";
card[14].card_value=3;
card[14].dealt=false;
card[15].card_name="FOUR";
card[15].card_type="diamond";
card[22].dealt=false;
card[23].card_name="JACK";
card[23].card_type="diamond";
card[23].card_value=10;
card[23].dealt=false;
card[24].card_name="QUEEN";
card[24].card_type="diamond";
card[24].card_value=10;
card[24].dealt=false;
card[25].card_name="KING";
card[25].card_type="diamond";
card[25].card_value=10;
card[25].dealt=false;
card[26].card_name="TWO";
card[26].card_type="spade";
card[26].card_value=2;
card[26].dealt=false;
card[27].card_name="THREE";
card[27].card_type="spade";
card[27].card_value=3;
card[27].dealt=false;
card[28].card_name="FOUR";
card[28].card_type="spade";
card[28].card_value=4;
card[28].dealt=false;
card[29].card_name="FIVE";
card[29].card_type="spade";
card[29].card_value=5;
card[29].dealt=false;
card[30].card_name="SIX";
card[30].card_type="spade";
card[30].card_value=6;
card[30].dealt=false;
card[31].card_name="SEVEN";
card[31].card_type="spade";
card[31].card_value=7;
card[31].dealt=false;
card[32].card_name="EIGHT";
card[32].card_type="spade";
card[32].card_value=8;
card[32].dealt=false;
card[33].card_name="NINE";
card[33].card_type="spade";
card[33].card_value=9;
card[33].dealt=false;
card[34].card_name="TEN";
card[34].card_type="spade";
card[34].card_value=10;
card[34].dealt=false;
card[35].card_name="ACE";
card[35].card_type="spade";
card[35].card_value=1;
card[35].dealt=false;
card[36].card_name="JACK";
card[36].card_type="spade";
card[36].card_value=10;
card[36].dealt=false;
card[37].card_name="QUEEN";
card[37].card_type="spade";
card[37].card_value=10;
card[37].dealt=false;
card[38].card_name="KING";
card[38].card_type="spade";
card[38].card_value=10;
card[38].dealt=false;
card[39].card_name="TWO";
card[39].card_type="club";
card[39].card_value=2;
card[39].dealt=false;
card[40].card_name="THREE";
card[40].card_type="club";
card[40].card_value=3;
card[40].dealt=false;
card[41].card_name="FOUR";
card[41].card_type="club";
card[41].card_value=4;
card[41].dealt=false;
card[42].card_name="FIVE";
card[42].card_type="club";
card[42].card_value=5;
card[42].dealt=false;
card[43].card_name="SIX";
card[43].card_type="club";
card[43].card_value=6;
card[43].dealt=false;
card[44].card_name="SEVEN";
card[44].card_type="club";
card[44].card_value=7;
card[44].dealt=false;
card[45].card_name="EIGHT";
card[45].card_type="club";
card[45].card_value=8;
card[45].dealt=false;
card[46].card_name="NINE";
card[46].card_type="club";
card[46].card_value=9;
card[46].dealt=false;
card[47].card_name="TEN";
card[47].card_type="club";
card[47].card_value=10;
card[47].dealt=false;
card[48].card_name="ACE";
card[48].card_type="club";
card[48].card_value=1;
card[48].dealt=false;
card[49].card_name="JACK";
card[49].card_type="club";
card[49].card_value=10;
card[49].dealt=false;
card[50].card_name="QUEEN";
card[50].card_type="club";
card[50].card_value=10;
card[50].dealt=false;
card[51].card_name="KING";
card[51].card_type="club";
card[51].card_value=10;
card[51].dealt=false;
}
void printdeck(deck card[])
{
//loop to print all cards
for (i=0; i<=51; ++i)
{
if((i==13)|
|(i==26)|
|(i==39))
System.out.println();
System.out.println(card[i].card_name+" "+card[i].card_type+" " +card[i].card_value+" "
+card[i].dealt);
}//for loop
}
void setBank (){ //Set bank to zero
playerBank =0;
}
void addBank(int value){ //Increment bank if win
playerBank += value;
}
void deductBank(int value){ //Deduct bank if loss
playerBank -= value;
}
void shuffle(deck card[]){ //Shuffle cards
for(int i = card.length-1;i>0;i--){
int random = (int) (Math.random()*(i+1)); //Get a random number and increase by 1
deck temp = card[i]; // temp to hold
card[i] = card[random]; //iterate
card[random] = temp; //switch
}
cardUsed = 0; //Since reshuffling set cards used to 0
}
deck dealCard(deck card[]){
return card[cardUsed++]; //Increment array to deal next card
}
boolean playAgain(){
String playAgain; //See if player wants to play again
System.out.println("Would you like to play again? (Y/N)");
Scanner scanner = new Scanner(System.in);
playAgain = scanner.next();
if (playAgain.equals("Y")){
timesPlayed++;
if (timesPlayed==10){ //If times played = 10 then get out
return false;
}
return true;
}
else return false;
}
}
class deck
{
String card_name;
String card_type;
int card_value;
boolean dealt;
}