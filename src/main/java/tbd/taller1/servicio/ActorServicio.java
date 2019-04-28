package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Actor;
import tbd.taller1.repositorio.ActorRepositorio;

@RestController
@RequestMapping("/actors")
@CrossOrigin(origins = "*")
public class ActorServicio {

    @Autowired
    private ActorRepositorio actorRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Actor> getAllUsers() {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Actor findOne(@PathVariable("id") Integer id) { return this.actorRepository.findActorByActorId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Actor create(@RequestBody Actor resource) {
        return actorRepository.save(resource);
    }

}
