package OrderRegression;

import tasks.GiftCertificatePageTasks;
import tasks.OrderDetailPageTasks;

public class GcAndProduct {

	public static void gcAndProduct() throws Exception {
		GiftCertificatePageTasks.giftCertificateForm();
		OrderDetailPageTasks.getOrderConfirmationPage();
	}
}
