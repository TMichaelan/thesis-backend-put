package work.service.event;

import work.dto.ResponseObject;
import work.dto.event.create.CreateCommentDto;
import work.dto.event.create.EventCreateDto;
import work.dto.event.get.certainevent.CertainEventDto;
import work.dto.event.get.EventsInRadiusDto;
import work.dto.event.get.SearchEventDTO;
import work.dto.event.get.certainevent.CommentDto;
import work.dto.event.get.certainevent.MembersForUserDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

public interface EventService {
    ResponseObject createEvent(HttpServletRequest request, EventCreateDto eventToCreate);

    ResponseObject createEventComment(HttpServletRequest request, CreateCommentDto createCommentDto, UUID eventId);

    ResponseObject addCurrentUserToEvent(HttpServletRequest request, UUID eventId);

    List<EventsInRadiusDto> getEventsWithinRadius(HttpServletRequest request, SearchEventDTO searchEventDTO);

    CertainEventDto getCertainEvent(UUID id);

    List<MembersForUserDto> getMembersForCertainEvent(UUID eventId);

    List<CommentDto> getCommentsForCertainEvent(UUID eventId);

    String isUserRegisteredToEvent(HttpServletRequest request, UUID eventId);

    ResponseObject removeCurrentUserFromEvent(HttpServletRequest request, UUID eventId);

    List<EventsInRadiusDto> getLastNEvents(Integer number);

    Integer getNumberOfPages(Integer numberOfEventOnPage, SearchEventDTO searchEventDTO);

    List<EventsInRadiusDto> getEventsWithPagination(Integer pageSize, Integer pageNumber, SearchEventDTO searchEventDTO);

    List<EventsInRadiusDto> getAllUserEvents(HttpServletRequest request);
}
