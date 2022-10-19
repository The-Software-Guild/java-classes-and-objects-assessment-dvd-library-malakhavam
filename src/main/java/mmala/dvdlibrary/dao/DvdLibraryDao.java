/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmala.dvdlibrary.dao;

import mmala.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mmala
 */
public interface DvdLibraryDao {
    List<Dvd> getAllDvds() throws DvdLibraryDaoException;
    
    Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryDaoException;

    Dvd removeDvd(String dvdTitle) throws DvdLibraryDaoException;
    
    Dvd getDvd(String dvdTitle) throws DvdLibraryDaoException;
    
    Map<String, Dvd> getDvdsLastYears(int years) throws DvdLibraryDaoException;
    
    Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating) throws DvdLibraryDaoException;
    
    Map<String, Dvd> getDvdsByDirector(String directorName) throws DvdLibraryDaoException;
    
    Map<String, Dvd> getDvdsByStudio(String studioName) throws DvdLibraryDaoException;

    Dvd changeReleaseDate(String title, LocalDate releaseDate)throws DvdLibraryDaoException;;

    Dvd changeMpaaRating(String title, String mpaaRating) throws DvdLibraryDaoException;;

    Dvd changeDirectorName(String title, String directorName) throws DvdLibraryDaoException;;

    Dvd changeUserRating(String title, String serRating) throws DvdLibraryDaoException;;

    Dvd changeStudioName(String title, String studioName) throws DvdLibraryDaoException;;
}
