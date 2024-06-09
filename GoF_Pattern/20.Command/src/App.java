public class App {
    public static void main(String[] args) throws Exception {
        CommandGroup cmdGroup = new CommandGroup();

        Command clearCmd = new ClearCommand();
        // console 창을 지운다.
        // clearCmd.run();
        cmdGroup.add(clearCmd);

        Command yellowColorCmd = new ColorCommand(ColorCommand.Color.YELLOW);
        // yellowColorCmd.run();
        cmdGroup.add(yellowColorCmd);

        Command moveCmd = new MoveCommand(10, 1);
        // moveCmd.run();
        cmdGroup.add(moveCmd);

        Command printCmd = new PrintCommand("Command design pattern");
        // printCmd.run();
        cmdGroup.add(printCmd);

        Command moveCmd2 = new MoveCommand(15, 5);
        // moveCmd2.run();
        cmdGroup.add(moveCmd2);

        // printCmd.run();
        cmdGroup.add(printCmd);

        Command moveCmd3 = new MoveCommand(25, 8);
        // moveCmd3.run();
        cmdGroup.add(moveCmd3);

        Command greenColorCmd = new ColorCommand(ColorCommand.Color.GREEN);
        // greenColorCmd.run();
        cmdGroup.add(greenColorCmd);

        // printCmd.run();
        cmdGroup.add(printCmd);

        // 객체에서 
        cmdGroup.run();

    }
    
}
