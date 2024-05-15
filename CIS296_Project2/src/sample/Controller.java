package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Controller {
    //declare needed variables
    private String playerChoice, computerChoice;
    private int playerScore, computerScore;
    private Image rockImage = new Image(getClass().getResourceAsStream("../imgs/rockImage.png")),
                    paperImage = new Image(getClass().getResourceAsStream("../imgs/paperImage.png")),
                    scissorsImage = new Image(getClass().getResourceAsStream("../imgs/scissorsImage.png")),
                    lizardImage = new Image(getClass().getResourceAsStream("../imgs/lizardImage.png")),
                    spockImage = new Image(getClass().getResourceAsStream("../imgs/spockImage.png"));


    @FXML
    private Label computerText = new Label(),
                    playerText = new Label(),
                    resultsText = new Label(),
                    playerScoreView = new Label(),
                    computerScoreView = new Label();
    @FXML
    private ImageView computerChoiceImage = new ImageView(),
                        playerChoiceImage = new ImageView(),
                        rockImageView = new ImageView(rockImage),
                        paperImageView = new ImageView(paperImage),
                        scissorsImageView = new ImageView(scissorsImage),
                        lizardImageView = new ImageView(lizardImage),
                        spockImageView = new ImageView(spockImage);

    ArrayList<String> possibleChoices = new ArrayList<>(Arrays.asList("rock", "paper", "scissors", "lizard", "spock"));
    Random rand = new Random();

    //Create the functions to handle when each choice is clicked
    @FXML
    private void rockClicked() {
        playerChoice = "rock";
        playerChoiceImage.setImage(rockImage);
        playerText.setText("You picked " + playerChoice);
        computerChooses();
    }

    @FXML
    void paperClicked() {
        playerChoice = "paper";
        playerChoiceImage.setImage(paperImage);
        playerText.setText("You picked " + playerChoice);
        computerChooses();
    }

    @FXML
    void scissorsClicked() {
        playerChoice = "scissors";
        playerChoiceImage.setImage(scissorsImage);
        playerText.setText("You picked " + playerChoice);
        computerChooses();
    }

    @FXML
    void lizardClicked() {
        playerChoice = "lizard";
        playerChoiceImage.setImage(lizardImage);
        playerText.setText("You picked " + playerChoice);
        computerChooses();
    }

    @FXML
    void spockClicked() {
        playerChoice = "spock";
        playerChoiceImage.setImage(spockImage);
        playerText.setText("Player  picked " + playerChoice);
        computerChooses();
    }

    private void computerChooses() {
        //make random computer selection
        computerChoice = possibleChoices.get(rand.nextInt(possibleChoices.size()));

        //set image accordingly
        if(computerChoice.equals("rock")) { computerChoiceImage.setImage(rockImage); }
        else if(computerChoice.equals("paper")){ computerChoiceImage.setImage(paperImage); }
        else if(computerChoice.equals("scissors")){ computerChoiceImage.setImage(scissorsImage); }
        else if(computerChoice.equals("lizard")) { computerChoiceImage.setImage(lizardImage); }
        else if(computerChoice.equals("spock")){ computerChoiceImage.setImage(spockImage); }

        computerText.setText("CPU picked " + computerChoice);
        checkWinner();
    }

    private void checkWinner() {
        if(playerChoice.equals(computerChoice)){
            resultsText.setText("It's a draw!\n" +
                    "No one wins...\n" +
                    "Try again!");
        }
        
        switch(playerChoice){
            case "rock":
                if(computerChoice.equals("paper")){ resultsText.setText("Paper covers rock!\nCPU wins!"); computerScore++;}
                else if(computerChoice.equals("scissors")){ resultsText.setText("Rock crushes scissors!\nPlayer wins!"); playerScore++;}
                else if(computerChoice.equals("lizard")) { resultsText.setText("Rock crushes lizard!\nPlayer wins!"); playerScore++;}
                else if(computerChoice.equals("spock")){ resultsText.setText("Spock vaporizes rock!\nCPU wins!"); computerScore++;}
                break;
            case "paper":
                if(computerChoice.equals("rock")){ resultsText.setText("Paper covers rock!\nPlayer wins!"); }
                else if(computerChoice.equals("scissors")){ resultsText.setText("Scissors cuts paper!\nCPU wins!"); }
                else if(computerChoice.equals("lizard")) { resultsText.setText("Lizard eats paper!\nCPU wins!"); }
                else if(computerChoice.equals("spock")){ resultsText.setText("Paper disproves spock!\nPlayer wins!"); }
                break;
            case "scissors":
                if(computerChoice.equals("rock")){ resultsText.setText("Rock crushes scissors!\nCPU wins!"); }
                else if(computerChoice.equals("paper")){ resultsText.setText("Scissors cuts paper!\nPlayer wins!"); }
                else if(computerChoice.equals("lizard")) { resultsText.setText("Scissors decapitates\nlizard!\nPlayer wins!"); }
                else if(computerChoice.equals("spock")){ resultsText.setText("Spock smashes\nscissors!\nCPU wins!" ); }
                break;
            case "lizard":
                if(computerChoice.equals("rock")){ resultsText.setText("Rock crushes lizard!\nCPU wins!"); }
                else if(computerChoice.equals("paper")){ resultsText.setText("Lizard eats paper!\nPlayer wins!"); }
                else if(computerChoice.equals("scissors")) { resultsText.setText("Scissors decapitates\nlizard!\nCPU wins!"); }
                else if(computerChoice.equals("spock")){ resultsText.setText("Lizard poisons spock!\nPlayer wins!" ); }
                break;
            case "spock":
                if(computerChoice.equals("rock")){ resultsText.setText("Spock vaporizes rock!\nPlayer wins!"); }
                else if(computerChoice.equals("paper")){ resultsText.setText("Paper disproves spock!\nCPU wins!"); }
                else if(computerChoice.equals("scissors")) { resultsText.setText("Spock smashes\nscissors!\nPlayer wins!"); }
                else if(computerChoice.equals("lizard")){ resultsText.setText("Lizard poisons spock!\nCPU wins!" ); }
                break;
            default:
                resultsText.setText("Error: Something went wrong... Try again.");
                break;
        }
    }
}
