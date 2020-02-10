package com.spooky.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spooky.languages.models.Language;
import com.spooky.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }

	public Language updateLanguage(Long id, String name, String creator, String version) {
		Optional<Language> updatedLanguage=languageRepository.findById(id);
		if(updatedLanguage.isPresent()) {
			Language languageToUpdate = updatedLanguage.get();
			languageToUpdate.setName(name);
			languageToUpdate.setCreator(creator);
			languageToUpdate.setVersion(version);
			return languageRepository.save(languageToUpdate);
		} else {
			return null;
		}
		}

}
