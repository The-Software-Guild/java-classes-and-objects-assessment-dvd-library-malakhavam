/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmala.dvdlibrary.controller;

import mmala.dvdlibrary.dao.DvdLibraryDao;
import mmala.dvdlibrary.dao.DvdLibraryDaoException;
import mmala.dvdlibrary.dto.Dvd;
import mmala.dvdlibrary.ui.DvdLibraryView;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

/**
 *
 * @author mmala
 */
public class DvdLibraryController {
    DvdLibraryView view;
    DvdLibraryDao dao;
    
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
   public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                        case 1:
                            createDvd();
                            break;
                        case 2:
                            removeDvd();
                            break;
                        case 3:
                            editDvd();
                            break;
                        case 4:
                            listDvds();
                            break;
                        case 5:
                            getDvd();
                            break;
                        case 6:
                            findDvds();
                            break;
                        case 7:
                            keepGoing = false;
                            break;
                        default:
                            unknownCommand();
                }
            }
            //io.print("exit");
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void createDvd()throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(),newDvd);
        view.displayCreateSuccessBanner();
    }
    private void listDvds() throws DvdLibraryDaoException {
        view.displayDvdListBanner();
        List <Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    private void getDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }
    private void removeDvd() throws DvdLibraryDaoException  {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }
    private void exitMessage() {
        view.displayExitBanner();
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void editDvd() throws DvdLibraryDaoException  {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvdToEdit = dao.getDvd(title);
        if (dvdToEdit==null) {
            view.displayNullDvd();
        } else {
            view.displayDvd(dvdToEdit);
            int editMenuSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = view.printEditMenuAndGetSelection();

                switch (editMenuSelection){
                    case 1:
                        editReleaseDate(title);
                        break;
                    case 2:
                        editMpaaRating(title);
                        break;
                    case 3:
                        editDirectorName(title);
                        break;
                    case 4:
                        editUserRating(title);
                        break;
                    case 5:
                        editStudioName(title);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                if (keepGoing == false) {
                    break;
            } 
        }
        }
    }
     

    private void editReleaseDate(String title) throws DvdLibraryDaoException {
        view.displayEditReleaseDateBanner();
        LocalDate newReleaseDate = view.getReleaseDate();
        Dvd editedDvd = dao.changeReleaseDate(title, newReleaseDate);
        view.displayEditResult();
    }
    private void editMpaaRating(String title) throws DvdLibraryDaoException {
        //view.displayEditMpaaRatingBanner();
        String newMpaaRating = view.getMpaaRating();
        Dvd editedDvd = dao.changeMpaaRating(title, newMpaaRating);
        view.displayEditResult();
    }
    private void editDirectorName(String title) throws DvdLibraryDaoException {
        
        String newDirectorName = view.getDirectorName();
        Dvd editDirectorName = dao.changeDirectorName(title, newDirectorName);
        view.displayEditResult();
    }
    private void editUserRating(String title) throws DvdLibraryDaoException {
        String newUserRating = view.getUserRating();
        Dvd changeUserRating = dao.changeUserRating(title, newUserRating);
        view.displayEditResult();
    }
    private void editStudioName(String title) throws DvdLibraryDaoException {
        String newStudioName = view.getStudioName();
        Dvd changeStudioName = dao.changeStudioName(title, newStudioName);
        view.displayEditResult();
    }
    
    private void findDvds() throws DvdLibraryDaoException {
        view.displayFindDvdsBanner();
            int findDvdsSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                findDvdsSelection = view.printFindMenuAndGetSelection();
                switch (findDvdsSelection){
                    case 1:
                        findMoviesLastNYears();
                        break;
                    case 2:
                        findMoviesByMpaaRating();
                        break;
                    case 3:
                        findMoviesByDirector();
                        break;
                    case 4:
                        findMoviesByStudio();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
              
            } 
        }
    private void findMoviesLastNYears() throws DvdLibraryDaoException {
        int n = view.getNYears();
        Map<String, Dvd> filteredDvds = dao.getDvdsLastYears(n);
        view.displayDvds(filteredDvds);
    }
    
    private void findMoviesByMpaaRating() throws DvdLibraryDaoException {
        String mpaaRating = view.getMpaaRating();
        Map<String, Dvd> filteredDvds = dao.getDvdsByMpaaRating(mpaaRating);
        view.displayDvds(filteredDvds);
    }
    
    private void findMoviesByDirector() throws DvdLibraryDaoException {
        String director = view.getDirectorName();
        Map<String, Dvd> filteredDvds = dao.getDvdsByDirector(director);
        view.displayDvds(filteredDvds);
    }
    private void findMoviesByStudio() throws DvdLibraryDaoException {
        String studio = view.getStudioName();
        Map<String, Dvd> filteredDvds = dao.getDvdsByStudio(studio);
        view.displayDvds(filteredDvds);
    }
 
    }
