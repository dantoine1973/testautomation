class Engine:
    def __init__(self, message=None):
        if message:
            print(message)
        else:
            print("Please put the key in the ignition.")

    def start(self):
        print("Engine started.")

    def stop(self):
        print("Engine stopped.")

""" my_engine = Engine("Start the engine by putting the key in the ignition.")
my_engine2 = Engine()
my_engine.start()
my_engine.stop()
my_engine2.start()
my_engine2.stop() """