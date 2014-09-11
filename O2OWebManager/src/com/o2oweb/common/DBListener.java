package com.o2oweb.common;

import org.apache.log4j.Logger;
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostDeleteEventListener;
import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;

/**
 * @author �������� zj
 * @version ����ʱ�䣺Feb 22, 2013 11:42:55 AM
 * ��˵��    ���ݿ��������
 */
public class DBListener implements PostInsertEventListener,   
        PostUpdateEventListener, PostDeleteEventListener {   
     private Logger logger = Logger.getLogger(DBListener.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void onPostInsert(PostInsertEvent arg0) {
//		logger.info("id: " + arg0.getId());
//		logger.info("state: " + arg0.getState());
//		logger.info("persister: " + arg0.getPersister());
//		logger.info("class: " + arg0.getClass());
//		logger.info("entity: " + arg0.getEntity());
//		logger.info("���� ������־");
	}

	public void onPostUpdate(PostUpdateEvent arg0) {

//		logger.info("id: " + arg0.getId());
//		logger.info("state: " + arg0.getState());
//		logger.info("oldState: " + arg0.getOldState());
//		logger.info("persister: " + arg0.getPersister());
//		logger.info("class: " + arg0.getClass());
//		logger.info("entity: " + arg0.getEntity());
//		logger.info("info: " + "���� �޸���־");
	}

	public void onPostDelete(PostDeleteEvent arg0) {
//		logger.info("id: " + arg0.getId());
//		logger.info("deleteState: " + arg0.getDeletedState());
//		logger.info("class: " + arg0.getClass());
//		logger.info("entity: " + arg0.getEntity());
//		logger.info("���� ɾ����־");
	} 
}  
