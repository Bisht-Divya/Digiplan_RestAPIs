package com.digiplan.servicesImpl;

import com.digiplan.entities.Notification;
import com.digiplan.repositories.NotificationRepository;
import com.digiplan.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, Notification updatedNotification) {
        if (notificationRepository.existsById(id)) {
            updatedNotification.setId(id);
            return notificationRepository.save(updatedNotification);
        }
        return null;
    }
//
//    @Override
//    public Notification deleteNotification(Long id) {
//       return notificationRepository.deleteById(id);
//    }

    @Override
    public Notification deleteNotification(Long id) {
        Optional<Notification> notificationOptional = notificationRepository.findById(id);

        if (notificationOptional.isPresent()) {
            Notification deletedNotification = notificationOptional.get();
            notificationRepository.deleteById(id);
            return deletedNotification;
        } else {
            return null;
        }
    }

@Override
public List<Object[]> callNotificationList(String fromDate, String toDate) {
    return notificationRepository.callNotificationList(fromDate, toDate);
}
}