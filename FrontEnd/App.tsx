import React from 'react';
import { SafeAreaView, StyleSheet, Text } from 'react-native';
import AntDesign from 'react-native-vector-icons/AntDesign';

interface Props { }

const App: React.FC<Props> = (props: Props) => {
  return (
    <SafeAreaView style={styles.container}>
      <AntDesign name={'customerservice'} size={40} />
      <Text>App.tsx</Text>
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white'
  }
})

export default App;