/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmala.dvdlibrary;

/**
 *
 * @author mmala
 */
import mmala.dvdlibrary.controller.DvdLibraryController;
import mmala.dvdlibrary.dao.DvdLibraryDao;
import mmala.dvdlibrary.dao.DvdLibraryDaoImpl;
import mmala.dvdlibrary.ui.DvdLibraryView;
import mmala.dvdlibrary.ui.UserIO;
import mmala.dvdlibrary.ui.UserIOConsoleImpl;

public class DvdLibrary {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl() {};
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
    }
    
}
