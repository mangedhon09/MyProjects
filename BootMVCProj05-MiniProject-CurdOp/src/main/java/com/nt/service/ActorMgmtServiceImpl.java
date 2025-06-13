package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;
@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
@Autowired
	private IActorRepository actorRepo;
	@Override
	public List<Actor> showAllActors() {
		
		return actorRepo.findAll();
	}
@Override
	public String registerActor(Actor actor) {
	//ser windows username as the created by username
	
	actor.setUpdatedBy(System.getProperty("user.name"));	
	//save the object
	int idVal=actorRepo.save(actor).getAid();
	return "Actor is saved with id value: "+idVal;
	
		
	}
@Override
public Actor fetchActorByID(int id) {
		
		return actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
	}
@Override
public String editActor(Actor actor) {
    System.out.println(actor.getAid());
    Optional<Actor> opt = actorRepo.findById(actor.getAid());
    if (opt.isPresent()) {
        Actor existingActor = opt.get();
        // Preserve update count and set updatedBy
        actor.setUpdateCount(existingActor.getUpdateCount());
        actor.setUpdatedBy(System.getProperty("user.name"));
        actorRepo.save(actor);
        return actor.getAid() + " Actor data is modified";
    }

    return actor.getAid() + " Actor is not found";
}
@Override
	public String deleteActorById(int id) {
		Optional<Actor>opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			actorRepo.deleteById(id);
			return id+"Actor is removed ";
			
		}
		return id+" actor is not found for deletion";
	}
}
