package designPattern.templateMethodPattern;
abstract class Employment {

        abstract void applyForJob();
        abstract void prepareForInterview();
        abstract void getOfferLetter();
        abstract void joinCompany();

        final void becomeEmployee()
        {
            applyForJob();
            prepareForInterview();
            getOfferLetter();
            joinCompany();
        }

    }

    class JobEmployementForJava extends  Employment
    {

        @Override
        void applyForJob() {
            System.out.println("Apply for Java Vacancy in XYZ company");
        }

        @Override
        void prepareForInterview() {
            System.out.println("Preparing for java interview Question");
        }

        @Override
        void getOfferLetter() {
            System.out.println("successfully crack the interview and got job  offer");
        }

        @Override
        void joinCompany() {
            System.out.println("after successfully completed BG join company @ xx/yy/zzzz date");
        }
    }

      class Test
      {
          public static void main(String[] args) {
              Employment emp = new JobEmployementForJava();
              emp.becomeEmployee();
          }
      }

