import main.*;

public class Launcher
{
    // main(boolean fullscreen)
    public static void main(String[] args){
        int w = 1920;
        int h = 1080;
        int mapNum = -1;
        //attempts to ask the user setup information
        SettingsGUI sg = new SettingsGUI("SCREENCAST", w, h, mapNum);
        sg.createSettingsGUI();
        
    }
}