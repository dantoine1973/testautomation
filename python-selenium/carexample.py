from oopexample import Engine

class Car(Engine):

#    model = ""

    def __init__(self, model):
        self.model = model
        super().__init__("Car created with model: " + self.model)

    def car_model(self):
        print("The model of this car is: " + self.model)

    def start_car(self):
        super().start()
        print("Car started.")

    def stop_car(self):
        super().stop()
        print("Car stopped.")

my_car = Car("Toyota Camry")
my_car.car_model()
my_car.start_car()
my_car.stop_car()