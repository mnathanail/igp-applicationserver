package igp.depo.model;

public class ResponseModel {

		private String text;
		private Object obj;

		public ResponseModel(String text) {
			this.text = text;
		}

		public ResponseModel(String text, Object obj) {
			this.text = text;
			this.obj = obj;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Object getObj() {
			return obj;
		}

		public void setObj(Object obj) {
			this.obj = obj;
		}
		
}
